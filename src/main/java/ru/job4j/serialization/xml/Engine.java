package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "engine")
public class Engine {
    @XmlAttribute
    private String name;

    public Engine() {
    }

    public Engine(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Engine{"
                + "name='" + name + '\''
                + '}';
    }
}