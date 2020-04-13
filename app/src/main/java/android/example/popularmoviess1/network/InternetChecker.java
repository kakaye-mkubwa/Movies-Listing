package android.example.popularmoviess1.network;

import android.os.AsyncTask;

import androidx.lifecycle.MutableLiveData;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

class InternetChecker extends AsyncTask<Void,Void,Boolean> {

    private MutableLiveData<Boolean>  internetStatus;

    public InternetChecker() {
        new InternetChecker().execute();
    }

    @Override
    protected Boolean doInBackground(Void... voids) {
        Socket socket = new Socket();
        try {
            socket.connect(new InetSocketAddress("8.8.8.8",53), 1500);
            socket.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        if (aBoolean != null){
            internetStatus = new MutableLiveData<>();
            internetStatus.setValue(aBoolean);
//        mConsumer.accept(aBoolean);
            setInternetStatus(internetStatus);
        }
    }

    public void setInternetStatus(MutableLiveData<Boolean> internetStatus) {
        this.internetStatus = internetStatus;
    }

    public MutableLiveData<Boolean> getInternetStatus() {
        return internetStatus;
    }
}
