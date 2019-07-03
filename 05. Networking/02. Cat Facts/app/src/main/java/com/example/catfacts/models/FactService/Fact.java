package com.example.catfacts.models.FactService;

class Fact {
    private String text;

    public Fact(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.text;
    }
}
