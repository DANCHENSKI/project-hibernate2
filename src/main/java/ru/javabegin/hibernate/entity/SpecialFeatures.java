package ru.javabegin.hibernate.entity;
import static java.util.Objects.isNull;

public enum SpecialFeatures {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");
    private  final  String value;

    SpecialFeatures(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public static SpecialFeatures getFeatureByValue(String value) {
        if(isNull(value) || value.isEmpty()) {
            return null;
        }

        SpecialFeatures[] features = SpecialFeatures.values();
        for (SpecialFeatures feature : features) {
                if (feature.value.equals(value)) {
                    return feature;
                }
        }
        return  null;
    }
}
