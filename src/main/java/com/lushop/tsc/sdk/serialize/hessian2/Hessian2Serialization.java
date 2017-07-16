package com.lushop.tsc.sdk.serialize.hessian2;


import com.caucho.hessian.io.*;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Created by Administrator on 2017/7/16.
 */
public class Hessian2Serialization {

    static final SerializerFactory serializerFactory = SerializerFactory.createDefault();
    static final ExtSerializerFactory extFactory = new ExtSerializerFactory();
    static{
        serializerFactory.addFactory(extFactory);

        addSerializer(java.math.BigDecimal.class,new StringValueSerializer());
        addDeserializer(java.math.BigDecimal.class,new StringValueDeserializer(BigDecimal.class));

        addSerializer(java.math.BigInteger.class,new StringValueSerializer());
        addDeserializer(java.math.BigInteger.class,new StringValueDeserializer(BigInteger.class));
    }

    public static void addSerializer(Class<?> cl, Serializer serializer){
        extFactory.addSerializer(cl,serializer);
    }

    public static void addDeserializer(Class<?> cl, Deserializer deserializer){
        extFactory.addDeserializer(cl,deserializer);
    }

    static AbstractHessianInput getAndCreateInput(InputStream in){
       final Hessian2Input input = new Hessian2Input(in);
        input.setSerializerFactory(serializerFactory);
        return input;
    }

    static AbstractHessianOutput getAndCreateOutput(OutputStream os){
        final Hessian2Output output = new Hessian2Output(os);
        output.setSerializerFactory(serializerFactory);
        return output;
    }

    public static <O> O deserialize(byte[] buf) throws IOException{
        final ByteArrayInputStream is = new ByteArrayInputStream(buf);
        final AbstractHessianInput input = getAndCreateInput(is);
        try {
            return (O) input.readObject();
        } finally {
            try {
                is.close();
            }catch (IOException ignore){
            }
        }

    }
    public static <O> byte[] serialize(O o) throws IOException{
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        final AbstractHessianOutput output = getAndCreateOutput(os);
        try{
            output.writeObject(o);
            output.flush();
            return os.toByteArray();
        } finally{
            try{
                os.close();;
            } catch(IOException igonre){}
        }
    }

}
