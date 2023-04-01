package com.automation.training.util.drivers;

import com.automation.training.exceptions.FailedUrlConnectionException;

import java.net.MalformedURLException;
import java.net.URL;

import static com.automation.training.exceptions.FailedUrlConnectionException.FAILED_URL_CALLING;

/**
 * AppiumServerAddress class to create the URL remote address
 * to communicate with the Appium server
 * @author luisaferco
 */
public class AppiumServerAddress {

      private String serverIp;
      private String serverPort;

      public AppiumServerAddress(String serverIp, String serverPort) {
            this.serverIp = serverIp;
            this.serverPort = serverPort;
      }

      private URL remoteAddress;
      public URL getRemoteAddress(){
            return remoteAddress;
      }
      public void setAddress() {
            try {
                  this.remoteAddress = new URL(String.format("http://%s:%s/wd/hub",serverIp,serverPort));
            } catch (MalformedURLException e) {
                  throw new FailedUrlConnectionException(String.format(FAILED_URL_CALLING, e.getMessage()));
            }
      }

}
