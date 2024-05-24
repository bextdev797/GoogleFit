package com.bextdev.googlefit;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.AndroidNonvisibleComponent;
import com.google.appinventor.components.runtime.ComponentContainer;
import com.google.appinventor.components.runtime.errors.YailRuntimeError;

public class GoogleFit extends AndroidNonvisibleComponent {
  private String appName;
  private String accessTokenOauth;

  public GoogleFit(ComponentContainer container) {
    super(container.$form());
  }

  public void checkResponseCode(HttpURLConnection httpConnection) throws Exception {
    int resCode = httpConnection.getResponseCode();
    if (resCode != HttpURLConnection.HTTP_OK) {
      throw new YailRuntimeError("Request failed: " + resCode, "GoogleFit Error");
    }
  }

  @SimpleFunction
  public void BloodGlucose(float level, int temporalRelationToMeal, int mealType, int temporalRelationToSleep, int specimenSource) {
    try {
      String googleFitUrl = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
      URL url = new URL(googleFitUrl);
      HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setRequestProperty("Content-Type", "application/json");
      httpConnection.setRequestProperty("Authorization", "Bearer" + accessTokenOauth);
    
      JSONObject dataStream = new JSONObject();
      dataStream.put("dataStreamName", "GoogleFit");
      dataStream.put("type", "derived");

      JSONObject application = new JSONObject();
      application.put("detailsUrl", "");
      application.put("name", appName);
      application.put("version", "1");
      dataStream.put("application", application);

      JSONObject dataType = new JSONObject();
      dataType.put("name", "com.google.blood_glucose");

      JSONObject bloodGlucoseField1 = new JSONObject();
      bloodGlucoseField1.put("name", "blood glucose level");
      bloodGlucoseField1.put("format", "float");
      bloodGlucoseField1.put("value", level);

      JSONObject bloodGlucoseField2 = new JSONObject();
      bloodGlucoseField2.put("name", "temporal relation to meal");
      bloodGlucoseField2.put("format", "integer");
      bloodGlucoseField2.put("value", temporalRelationToMeal);

      JSONObject bloodGlucoseField3 = new JSONObject();
      bloodGlucoseField3.put("name", "meal type");
      bloodGlucoseField3.put("format", "integer");
      bloodGlucoseField3.put("value", mealType);

      JSONObject bloodGlucoseField4 = new JSONObject();
      bloodGlucoseField4.put("name", "temporal relation to sleep");
      bloodGlucoseField4.put("format", "integer");
      bloodGlucoseField4.put("value", temporalRelationToSleep);

      JSONObject bloodGlucoseField5 = new JSONObject();
      bloodGlucoseField5.put("name", "specimen source");
      bloodGlucoseField5.put("format", "integer");
      bloodGlucoseField5.put("value", specimenSource);

      JSONArray fields = new JSONArray();
      fields.put(bloodGlucoseField1);
      fields.put(bloodGlucoseField2);
      fields.put(bloodGlucoseField3);
      fields.put(bloodGlucoseField4);
      fields.put(bloodGlucoseField5);

      dataType.put("field", fields);
      dataStream.put("dataType", dataType);

      OutputStreamWriter os = new OutputStreamWriter(httpConnection.getOutputStream());
      os.write(dataStream.toString());
      os.flush();
      os.close();
      checkResponseCode(httpConnection);
    } catch (Exception e) {
      throw new YailRuntimeError(e.getMessage(), "GoogleFit Error");
    }
  }

  @SimpleFunction
  public void BloodPressure(float systolic, float diastolic, int bodyPosition, int measurementLocation) {
    try {
      String googleFitUrl = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
      URL url = new URL(googleFitUrl);
      HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setRequestProperty("Content-Type", "application/json");
      httpConnection.setRequestProperty("Authorization", "Bearer" + accessTokenOauth);

      JSONObject dataStream = new JSONObject();
      dataStream.put("dataStreamName", "GoogleFit");
      dataStream.put("type", "derived");

      JSONObject application = new JSONObject();
      application.put("detailsUrl", "");
      application.put("name", appName);
      application.put("version", "1");
      dataStream.put("application", application);

      JSONObject dataType = new JSONObject();
      dataType.put("name", "com.google.blood_pressure");

      JSONObject bloodPressureField1 = new JSONObject();
      bloodPressureField1.put("name", "systolic");
      bloodPressureField1.put("format", "float");
      bloodPressureField1.put("value", systolic);

      JSONObject bloodPressureField2 = new JSONObject();
      bloodPressureField2.put("name", "diastolic");
      bloodPressureField2.put("format", "float");
      bloodPressureField2.put("value", diastolic);

      JSONObject bloodPressureField3 = new JSONObject();
      bloodPressureField3.put("name", "body position");
      bloodPressureField3.put("format", "integer");
      bloodPressureField3.put("value", bodyPosition);

      JSONObject bloodPressureField4 = new JSONObject();
      bloodPressureField4.put("name", "measurement location");
      bloodPressureField4.put("format", "integer");
      bloodPressureField4.put("value", measurementLocation);

      JSONArray fields = new JSONArray();
      fields.put(bloodPressureField1);
      fields.put(bloodPressureField2);
      fields.put(bloodPressureField3);
      fields.put(bloodPressureField4);

      dataType.put("field", fields);
      dataStream.put("dataType", dataType);

      OutputStreamWriter os = new OutputStreamWriter(httpConnection.getOutputStream());
      os.write(dataStream.toString());
      os.flush();
      os.close();
      checkResponseCode(httpConnection);
    } catch (Exception e) {
      throw new YailRuntimeError(e.getMessage(), "GoogleFit Error");
    }
  }

  @SimpleFunction
  public void BodyFatPercentage(float percentage) {
    try {
      String googleFitUrl = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
      URL url = new URL(googleFitUrl);
      HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setRequestProperty("Content-Type", "application/json");
      httpConnection.setRequestProperty("Authorization", "Bearer" + accessTokenOauth);

      JSONObject dataStream = new JSONObject();
      dataStream.put("dataStreamName", "GoogleFit");
      dataStream.put("type", "derived");

      JSONObject application = new JSONObject();
      application.put("detailsUrl", "");
      application.put("name", appName);
      application.put("version", "1");
      dataStream.put("application", application);

      JSONObject dataType = new JSONObject();
      dataType.put("name", "com.google.body.fat.percentage");

      JSONObject field = new JSONObject();
      field.put("name", "percentage");
      field.put("format", "float");
      field.put("value", percentage);

      JSONArray fields = new JSONArray();
      fields.put(field);

      dataType.put("field", fields);
      dataStream.put("dataType", dataType);

      OutputStreamWriter os = new OutputStreamWriter(httpConnection.getOutputStream());
      os.write(dataStream.toString());
      os.flush();
      os.close();
      checkResponseCode(httpConnection);
    } catch (Exception e) {
      throw new YailRuntimeError(e.getMessage(), "GoogleFit Error");
    }
  }

  @SimpleFunction
  public void Height(float height) {
    try {
      String googleFitUrl = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
      URL url = new URL(googleFitUrl);
      HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setRequestProperty("Content-Type", "application/json");
      httpConnection.setRequestProperty("Authorization", "Bearer" + accessTokenOauth);

      JSONObject dataStream = new JSONObject();
      dataStream.put("dataStreamName", "GoogleFit");
      dataStream.put("type", "derived");

      JSONObject application = new JSONObject();
      application.put("detailsUrl", "");
      application.put("name", appName);
      application.put("version", "1");
      dataStream.put("application", application);

      JSONObject dataType = new JSONObject();
      dataType.put("name", "com.google.height");

      JSONObject field = new JSONObject();
      field.put("name", "height");
      field.put("format", "float");
      field.put("value", height);

      JSONArray fields = new JSONArray();
      fields.put(field);

      dataType.put("field", fields);
      dataStream.put("dataType", dataType);

      OutputStreamWriter os = new OutputStreamWriter(httpConnection.getOutputStream());
      os.write(dataStream.toString());
      os.flush();
      os.close();
      checkResponseCode(httpConnection);
    } catch (Exception e) {
      throw new YailRuntimeError(e.getMessage(), "GoogleFit Error");
    }
  }

  @SimpleFunction
  public void CaloriesBurned(float calories) {
    try {
      String googleFitUrl = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
      URL url = new URL(googleFitUrl);
      HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setRequestProperty("Content-Type", "application/json");
      httpConnection.setRequestProperty("Authorization", "Bearer" + accessTokenOauth);

      JSONObject dataStream = new JSONObject();
      dataStream.put("dataStreamName", "GoogleFit");
      dataStream.put("type", "derived");

      JSONObject application = new JSONObject();
      application.put("detailsUrl", "");
      application.put("name", appName);
      application.put("version", "1");
      dataStream.put("application", application);

      JSONObject dataType = new JSONObject();
      dataType.put("name", "com.google.calories.expended");

      JSONObject field = new JSONObject();
      field.put("name", "calories");
      field.put("format", "float");
      field.put("value", calories);

      JSONArray fields = new JSONArray();
      fields.put(field);

      dataType.put("field", fields);
      dataStream.put("dataType", dataType);

      OutputStreamWriter os = new OutputStreamWriter(httpConnection.getOutputStream());
      os.write(dataStream.toString());
      os.flush();
      os.close();
      checkResponseCode(httpConnection);
    } catch (Exception e) {
      throw new YailRuntimeError(e.getMessage(), "GoogleFit Error");
    }
  }

  @SimpleFunction
  public void CyclingPedalingCadence(float rpm) {
    try {
      String googleFitUrl = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
      URL url = new URL(googleFitUrl);
      HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setRequestProperty("Content-Type", "application/json");
      httpConnection.setRequestProperty("Authorization", "Bearer" + accessTokenOauth);

      JSONObject dataStream = new JSONObject();
      dataStream.put("dataStreamName", "GoogleFit");
      dataStream.put("type", "derived");

      JSONObject application = new JSONObject();
      application.put("detailsUrl", "");
      application.put("name", appName);
      application.put("version", "1");
      dataStream.put("application", application);

      JSONObject dataType = new JSONObject();
      dataType.put("name", "com.google.cycling.pedaling.cadence");

      JSONObject field = new JSONObject();
      field.put("name", "rpm");
      field.put("format", "float");
      field.put("value", rpm);

      JSONArray fields = new JSONArray();
      fields.put(field);

      dataType.put("field", fields);
      dataStream.put("dataType", dataType);

      OutputStreamWriter os = new OutputStreamWriter(httpConnection.getOutputStream());
      os.write(dataStream.toString());
      os.flush();
      os.close();
      checkResponseCode(httpConnection);
    } catch (Exception e) {
      throw new YailRuntimeError(e.getMessage(), "GoogleFit Error");
    }
  }

  @SimpleFunction
  public void CyclingPedalingCumulative(int revolution) {
    try {
      String googleFitUrl = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
      URL url = new URL(googleFitUrl);
      HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setRequestProperty("Content-Type", "application/json");
      httpConnection.setRequestProperty("Authorization", "Bearer" + accessTokenOauth);

      JSONObject dataStream = new JSONObject();
      dataStream.put("dataStreamName", "GoogleFit");
      dataStream.put("type", "derived");

      JSONObject application = new JSONObject();
      application.put("detailsUrl", "");
      application.put("name", appName);
      application.put("version", "1");
      dataStream.put("application", application);

      JSONObject dataType = new JSONObject();
      dataType.put("name", "com.google.cycling.pedaling.cumulative");

      JSONObject field = new JSONObject();
      field.put("name", "revolution");
      field.put("format", "int");
      field.put("value", revolution);

      JSONArray fields = new JSONArray();
      fields.put(field);

      dataType.put("field", fields);
      dataStream.put("dataType", dataType);

      OutputStreamWriter os = new OutputStreamWriter(httpConnection.getOutputStream());
      os.write(dataStream.toString());
      os.flush();
      os.close();
      checkResponseCode(httpConnection);
    } catch (Exception e) {
      throw new YailRuntimeError(e.getMessage(), "GoogleFit Error");
    }
  }

  @SimpleFunction
  public void HeartRate(float bpm) {
    try {
      String googleFitUrl = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
      URL url = new URL(googleFitUrl);
      HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setRequestProperty("Content-Type", "application/json");
      httpConnection.setRequestProperty("Authorization", "Bearer" + accessTokenOauth);

      JSONObject dataStream = new JSONObject();
      dataStream.put("dataStreamName", "GoogleFit");
      dataStream.put("type", "derived");

      JSONObject application = new JSONObject();
      application.put("detailsUrl", "");
      application.put("name", appName);
      application.put("version", "1");
      dataStream.put("application", application);

      JSONObject dataType = new JSONObject();
      dataType.put("name", "com.google.heart.minutes");

      JSONObject field = new JSONObject();
      field.put("name", "bpm");
      field.put("format", "float");
      field.put("value", bpm);

      JSONArray fields = new JSONArray();
      fields.put(field);

      dataType.put("field", fields);
      dataStream.put("dataType", dataType);

      OutputStreamWriter os = new OutputStreamWriter(httpConnection.getOutputStream());
      os.write(dataStream.toString());
      os.flush();
      os.close();
      checkResponseCode(httpConnection);
    } catch (Exception e) {
      throw new YailRuntimeError(e.getMessage(), "GoogleFit Error");
    }
  }

  @SimpleFunction
  public void HeartPoints(float intensity) {
    try {
      String googleFitUrl = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
      URL url = new URL(googleFitUrl);
      HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setRequestProperty("Content-Type", "application/json");
      httpConnection.setRequestProperty("Authorization", "Bearer" + accessTokenOauth);

      JSONObject dataStream = new JSONObject();
      dataStream.put("dataStreamName", "GoogleFit");
      dataStream.put("type", "derived");

      JSONObject application = new JSONObject();
      application.put("detailsUrl", "");
      application.put("name", appName);
      application.put("version", "1");
      dataStream.put("application", application);

      JSONObject dataType = new JSONObject();
      dataType.put("name", "com.google.heart.minutes");

      JSONObject field = new JSONObject();
      field.put("name", "intensity");
      field.put("format", "float");
      field.put("value", intensity);

      JSONArray fields = new JSONArray();
      fields.put(field);

      dataType.put("field", fields);
      dataStream.put("dataType", dataType);

      OutputStreamWriter os = new OutputStreamWriter(httpConnection.getOutputStream());
      os.write(dataStream.toString());
      os.flush();
      os.close();
      checkResponseCode(httpConnection);
    } catch (Exception e) {
      throw new YailRuntimeError(e.getMessage(), "GoogleFit Error");
    }
  }

  @SimpleFunction
  public void CercivalMucus(int cercivalMucusTexture, int cercivalMucusAmount) {
    try {
      String googleFitUrl = "https://www.googleapis.com/fitness/v1/users/me/dataSources";
      URL url = new URL(googleFitUrl);
      HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
      httpConnection.setRequestMethod("POST");
      httpConnection.setRequestProperty("Content-Type", "application/json");
      httpConnection.setRequestProperty("Authorization", "Bearer" + accessTokenOauth);

      JSONObject dataStream = new JSONObject();
      dataStream.put("dataStreamName", "GoogleFit");
      dataStream.put("type", "derived");

      JSONObject application = new JSONObject();
      application.put("detailsUrl", "");
      application.put("name", appName);
      application.put("version", "1");
      dataStream.put("application", application);

      JSONObject dataType = new JSONObject();
      dataType.put("name", "com.google.blood_pressure");

      JSONObject cercivalMucusField1 = new JSONObject();
      cercivalMucusField1.put("name", "cercival mucus texture");
      cercivalMucusField1.put("format", "integer");
      cercivalMucusField1.put("value", cercivalMucusTexture);

      JSONObject cercivalMucusField2 = new JSONObject();
      cercivalMucusField2.put("name", "cercival mucus amount");
      cercivalMucusField2.put("format", "integer");
      cercivalMucusField2.put("value", cercivalMucusAmount);

      JSONArray fields = new JSONArray();
      fields.put(cercivalMucusField1);
      fields.put(cercivalMucusField2);

      dataType.put("field", fields);
      dataStream.put("dataType", dataType);

      OutputStreamWriter os = new OutputStreamWriter(httpConnection.getOutputStream());
      os.write(dataStream.toString());
      os.flush();
      os.close();
      checkResponseCode(httpConnection);
    } catch (Exception e) {
      throw new YailRuntimeError(e.getMessage(), "GoogleFit Error");
    }
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_TEXTAREA, defaultValue = "GoogleFit")
  @SimpleProperty
  public void AppName(String name) {
    appName = name;
  }

  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_TEXTAREA, defaultValue = "YOUR_ACCESS_TOKEN")
  @SimpleProperty
  public void OAuthAccessToken(String accessToken) {
    accessTokenOauth = accessToken;
  }
}