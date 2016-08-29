/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
/*
 * This code was generated by https://github.com/google/apis-client-generator/
 * (build: 2016-07-08 17:28:43 UTC)
 * on 2016-08-29 at 20:17:07 UTC 
 * Modify at your own risk.
 */

package com.udacity.backend.jokeApi.model;

/**
 * Model definition for Joke.
 *
 * <p> This is the Java data model class that specifies how to parse/serialize into the JSON that is
 * transmitted over HTTP when working with the jokeApi. For a detailed explanation see:
 * <a href="https://developers.google.com/api-client-library/java/google-http-java-client/json">https://developers.google.com/api-client-library/java/google-http-java-client/json</a>
 * </p>
 *
 * @author Google, Inc.
 */
@SuppressWarnings("javadoc")
public final class Joke extends com.google.api.client.json.GenericJson {

  /**
   * The value may be {@code null}.
   */
  @com.google.api.client.util.Key
  private java.lang.String jokeText;

  /**
   * @return value or {@code null} for none
   */
  public java.lang.String getJokeText() {
    return jokeText;
  }

  /**
   * @param jokeText jokeText or {@code null} for none
   */
  public Joke setJokeText(java.lang.String jokeText) {
    this.jokeText = jokeText;
    return this;
  }

  @Override
  public Joke set(String fieldName, Object value) {
    return (Joke) super.set(fieldName, value);
  }

  @Override
  public Joke clone() {
    return (Joke) super.clone();
  }

}
