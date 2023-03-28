package co.com.sofka.model.common.ex;

import java.util.function.Supplier;

public class BusinessException extends ApplicationException {

    private static final long serialVersionUID = 1L;

    public enum Type {

        ID_DUPLICADO("Se detecto que el id ya esta registrado"),
        USUARIO_NO_EXISTE("Se detecto que el pensionado no existe");

        private final String message;

        public String getMessage() {
            return message;
        }

        public BusinessException build() {
            return new BusinessException(this);
        }

        public Supplier<Throwable> defer() {
            return () -> new BusinessException(this);
        }

        Type(String message) {
            this.message = message;
        }

    }

    private final Type type;

    public BusinessException(Type type){
        super(type.message);
        this.type = type;
    }

    public BusinessException(Type type,String menssage){
        super(menssage);
        this.type = type;
    }

    @Override
    public String getCode(){
        return type.name();
    }


}
