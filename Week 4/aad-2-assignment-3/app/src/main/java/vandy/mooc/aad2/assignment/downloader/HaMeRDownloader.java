package vandy.mooc.aad2.assignment.downloader;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/**
 * A HaMeR downloader implementation that uses two Runnables and a background
 * thread to download a single image in a background thread.
 * <p/>
 * The base ImageDownloader class provides helper methods to perform the
 * download operation as well as to return the resulting image bitmap to the
 * framework where it will be displayed in a layout ImageView.
 */
public class HaMeRDownloader extends ImageDownloader {
    /**
     * Logging tag.
     */
    private static final String TAG = "HaMeRDownloader";

    /**
     * Create a new handler that is associated with the main thread looper.
     */
    // Create a private final Handler associated with the main thread looper.
    // Note that this class and all its fields are instantiated in the main thread.
    // TODO - you fill in here.
    private AsyncTask<Void, Void, Bitmap> mTask;
    /**
     * A reference to the background thread to support the cancel hook.
     */
    private Thread mThread;

    /**
     * Starts the asynchronous download request.
     */
    @Override
    public void execute() {
        mTask = new AsyncTask<Void, Void, Bitmap>() {
            //  In the background: Call abstract class helper method to perform the download request and decode the resource.
            @Override
            protected Bitmap doInBackground(Void... params) {
                return download();
            }
            //  After downloading is complete: Call the super class setResource helper method to set the resource.
            //  The helper will also display and error bitmap if the passed bitmap is null (signalling a failed download).
            @Override
            protected void onPostExecute(Bitmap image) {
                if(image != null)
                    postResult(image);
                else
                    postResult(null);

            }
        };

        //  run mTask.
        mTask.execute();

    }

    /**
     * Cancels the current download operation.
     */
    @Override
    public void cancel() {
        // Call local isRunning() helper method to check if mThread
        // is currently running; if it is running, cancel it by calling its
        // interrupt() helper method.
        // TODO - you fill in here.
        mTask.cancel(isRunning());
    }

    /**
     * Reports if the task is currently running.
     *
     * @return {@code true} if the task is running; {@code false} if not.
     */
    @Override
    public boolean isRunning() {
        // Return 'true' if mThread is not null and is running
        // (see isAlive() helper method)

        // TODO - you fill in here replacing the following statement with your solution.
        return mTask.getStatus() == AsyncTask.Status.RUNNING;
    }

    /**
     * Reports if the task has been cancelled.
     *
     * @return {@code true} if the task has cancelled ; {@code false} if not.
     */
    @Override
    public boolean isCancelled() {
        // Return 'true' if mThread is not null and has been
        // interrupted (see isInterrupted() helper method).

        // TODO - you fill in here replacing the following statement with your solution.
        return mTask.isCancelled();
    }

    /**
     * Reports if the download thread has completed.
     *
     * @return {@code true} if the task has successfully completed; {@code
     * false} if not.
     */
    @Override
    public boolean hasCompleted() {
        // Return 'true' if mThread is not null and has successfully
        // terminated (completed). To determine if a thread has terminated,
        // you will need to use the Thread's getState() helper method and
        // compare it to the the appropriate Thread.State enumerated value.

        // TODO - you fill in here replacing the following statement with your solution.
        return mTask.getStatus() == AsyncTask.Status.FINISHED;

    }
}
