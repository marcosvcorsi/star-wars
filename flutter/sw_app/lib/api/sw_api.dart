import 'dart:convert';

import "package:http/http.dart" as http;

class SWApi {

  static final String _baseUrl = "https://swapi.co/api/";

  static Future<Map> get({String endpoint, int page = 1}) async {
    http.Response response = await http.get("$_baseUrl$endpoint/?page=$page");

    return json.decode(response.body);
  }
}