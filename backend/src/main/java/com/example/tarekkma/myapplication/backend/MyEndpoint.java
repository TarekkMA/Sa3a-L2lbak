/*
   For step-by-step instructions on connecting your Android application to this backend module,
   see "App Engine Java Endpoints Module" template documentation at
   https://github.com/GoogleCloudPlatform/gradle-appengine-templates/tree/master/HelloEndpoints
*/

package com.example.tarekkma.myapplication.backend;

import com.example.Joke;
import com.example.JokeSimth;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;

import javax.inject.Named;

/** An endpoint class we are exposing */
@Api(name = "myApi", version = "v1", namespace = @ApiNamespace(ownerDomain = "backend.myapplication.tarekkma.example.com", ownerName = "backend.myapplication.tarekkma.example.com", packagePath = ""))
public class MyEndpoint {

  @ApiMethod(name = "getNewJoke") public Joke getNewJoke(@Named("deviceUUID") String uuid) {
    Joke response = new JokeSimth(uuid).getJoke();

    return response;
  }
}
