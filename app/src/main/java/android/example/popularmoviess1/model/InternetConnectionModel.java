package android.example.popularmoviess1.model;

public class InternetConnectionModel {
    private int connectionType;
    private boolean isConnected;

    public InternetConnectionModel(int connectionType, boolean isConnected) {
        this.connectionType = connectionType;
        this.isConnected = isConnected;
    }

    public int getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(int connectionType) {
        this.connectionType = connectionType;
    }

    public boolean isConnected() {
        return isConnected;
    }

    public void setConnected(boolean connected) {
        isConnected = connected;
    }
}
