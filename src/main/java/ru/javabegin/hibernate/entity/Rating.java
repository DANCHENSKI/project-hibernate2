package ru.javabegin.hibernate.entity;

public enum Rating {
        G,
        PG,
        PG_13("PG-13"),
        R,
        NC_17("NC-17");

        private final String value;

        Rating() {
            this.value = name();
        }

        Rating(String value){
                this.value = value;
        }

        public String getValue() {
            return value;
        }
}
