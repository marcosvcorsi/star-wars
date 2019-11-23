
import 'package:flutter/material.dart';
import 'package:starwars_app/dto/result-dto.dart';
import 'package:starwars_app/models/people.dart';
import 'package:starwars_app/services/api.dart';

class PeoplePage extends StatefulWidget {
  @override
  PeopleState createState() => PeopleState();
}

class PeopleState extends State<PeoplePage> {

  ResultDTO<People> _page = new ResultDTO<People>();

  @override
  void initState() {
    super.initState();
    _populatePeople();
  }

  void _populatePeople() {
    Api().load('https://swapi.co/api/people').then(
            (result) {
              _page = ResultDTO<People>.fromJson(result);

              debugPrint('${_page.results}');
            }
    );
  }

  @override
  Widget build(BuildContext context) {
    // TODO: implement build

    final List<String> data = <String>['Teste', 'Teste2', 'Teste3'];

    return Scaffold(
      body: ListView.builder(
          padding: const EdgeInsets.all(8),
          itemCount: data.length,
          itemBuilder: (BuildContext context, int index) {
            return Container(
              height: 50,
              child: Text('${data[index]}')
            );
          }
      )
    );
  }
}