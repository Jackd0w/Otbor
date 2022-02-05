package FifthProblem;

public class Safe {

    String model;
    int size;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int volume) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Safe{" +
                "model='" + model + '\'' +
                ", volume=" + size +
                '}';
    }
}