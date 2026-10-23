package javaKeywords;

public interface Person {
    public void showName();
    public abstract void showCity();
    public default void showAddress(){

    }

}
