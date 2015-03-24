package com.example.cxfss.get_my_object_soap_ws_1_0;

import java.io.IOException;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
//import org.apache.wss4j.common.ext.WSPasswordCallback;//do this when upgrade to newer cxf version.
import org.apache.ws.security.WSPasswordCallback;//remove this when upgrading to newer cxf version.

public class PasswordCallbackHandler implements CallbackHandler {

	@Override
	public void handle(Callback[] callbacks) throws IOException, UnsupportedCallbackException {

		for (int i = 0; i < callbacks.length; i++ ) {

			Callback callback = callbacks[i];

			if (callbacks.length != 1) {
				//Log some error? Don't know if it should ever be != 1.
			}
			if (callback instanceof WSPasswordCallback) {
				WSPasswordCallback passwordCallback = (WSPasswordCallback) callback;

				if (passwordCallback.getIdentifier().equals("admin")) {
					// set the password on the callback. This will be compared to the
					// password which was sent from the client.
					passwordCallback.setPassword("admin");
				}
			}
			else {
				throw new UnsupportedCallbackException(callback, "Unsupported callback.");
			}
		}

	}

}