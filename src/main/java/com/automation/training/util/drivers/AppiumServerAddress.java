package com.automation.training.util.drivers;

import com.automation.training.exceptions.FailedUrlConnectionException;
import java.net.MalformedURLException;
import java.net.URL;
import static com.automation.training.exceptions.FailedUrlConnectionException.FAILED_URL_CALLING;

public class AppiumServerAddress {

      private URL remoteAddress;
      public URL getRemoteAddress(){
            return remoteAddress;
      }
      public void setAddress() {
            try {
                  this.remoteAddress = new URL("http://127.0.0.1:4723/wd/hub");
            } catch (MalformedURLException e) {
                  throw new FailedUrlConnectionException(String.format(FAILED_URL_CALLING, e.getMessage()));
            }
      }

}
