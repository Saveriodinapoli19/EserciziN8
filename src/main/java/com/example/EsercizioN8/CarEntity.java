package com.example.EsercizioN8;

import jakarta.persistence.*;

@Entity
@Table
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String modelName;
    @Column(nullable = false)
    private String type;

    public CarEntity(Long id, String modelName, String type) {
        this.id = id;
        this.modelName = modelName;
        this.type = type;
    }

    public CarEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", modelName='" + modelName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
