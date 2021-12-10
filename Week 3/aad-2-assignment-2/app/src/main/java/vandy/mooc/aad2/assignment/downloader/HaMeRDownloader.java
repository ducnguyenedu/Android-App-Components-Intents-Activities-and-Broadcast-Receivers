package vandy.mooc.aad2.assignment.downloader;

import android.graphics.Bitmap;
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
    
    /**
     * A reference to the background thread to support the cancel hook.
     */
    private Thread mThread;

    /**
     * Starts the asynchronous download request.
     */
    @Override
    public void execute() {
        // Create a new final Runnable called 'downloadRunnable' to
        // process the download request (replace the null).
        // TODO - you fill in here.

        Runnable downloadRunnable = () -> {
            // Within the new runnable's run() method:

            // Call the HaMeRDownloader helper method to
            // determine if this thread has been interrupted; if so,
            // just return to terminate the thread.
            // TODO - you fill in here.
            

            // Call ImageDownloader super class helper method download()
            // to download the bitmap.
            // TODO - you fill in here.
            


            // Since the download my take a while, check again to
            // make sure that this thread has not been interrupted (using
            // the same helper method as above); if it has been interrupted
            // then just return to terminate the thread.
            // TODO - you fill in here.
            

            // Use the mHandler post(...) helper method to post
            // a new Runnable to the main thread. This Runnable's run()
            // method should simply call the ImageDownloader super class
            // helper method postResult(...) to pass the downloaded bitmap
            // to the application UI layer (activity) to display.
            // TODO - you fill in here.
            
        };
        // Create a new Thread instance that will run the
        // 'downloadRunnable' created above, and assign it to the mThread
        // field. This assignment is necessary to support cancelling this
        // thread and the download operation.
        // TODO - you fill in here.
        

        // Start the thread.
        // TODO - you fill in here.
        
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
        return false;
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
        return false;
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
        return false;
    }
}
