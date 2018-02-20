package com.practicalunittesting.c5.c7.c3;

public class ClassRoom {

    private String name;
    private int capacity;
    private boolean projector;
    private boolean microphone;
    private boolean whiteboard;

    public ClassRoom(String name, int capacity, boolean projector, boolean microphone, boolean whiteboard) {
        this.name = name;
        this.capacity = capacity;
        this.projector = projector;
        this.microphone = microphone;
        this.whiteboard = whiteboard;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean hasProjector() {
        return projector;
    }

    public boolean hasMicrophone() {
        return microphone;
    }

    public boolean hasWhiteboard() {
        return whiteboard;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ClassRoom)) return false;

        ClassRoom classRoom = (ClassRoom) o;

        return getName().equals(classRoom.getName());
    }

    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}
