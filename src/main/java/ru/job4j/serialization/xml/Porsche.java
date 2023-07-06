package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.*;
import java.util.Arrays;

@XmlRootElement(name = "porsche")
@XmlAccessorType(XmlAccessType.FIELD)
public class Porsche {
    @XmlAttribute
    private boolean isCabriolet;
    private int engineVolume;
    private String fuel;
    private Engine engine;

    @XmlElementWrapper(name = "descriptions")
    @XmlElement(name = "description")
    private String[] description;

    public Porsche() {
    }

    public Porsche(boolean isCabriolet, int engineVolume, String fuel,
                   Engine engine, String[] description) {
        this.isCabriolet = isCabriolet;
        this.engineVolume = engineVolume;
        this.fuel = fuel;
        this.engine = engine;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Porsche{"
                + "isCabriolet=" + isCabriolet
                + ", engineVolume=" + engineVolume
                + ", fuel='" + fuel + '\''
                + ", engine=" + engine
                + ", description=" + Arrays.toString(description)
                + '}';
    }
}