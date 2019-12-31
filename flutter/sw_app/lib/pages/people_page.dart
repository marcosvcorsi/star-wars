import 'package:flutter/material.dart';
import 'package:sw_app/api/sw_api.dart';

class PeoplePage extends StatefulWidget {
  @override
  _PeoplePageState createState() => _PeoplePageState();
}

class _PeoplePageState extends State<PeoplePage> {
  List _peopleList = List();
  int _page = 1;

  @override
  void initState() {
    super.initState();

    this._loadData();
  }

  void _loadData() async {
    Map<String, dynamic> data =
        await SWApi.get(endpoint: "people", page: _page);

    setState(() {
      _peopleList = data["results"];
    });
  }

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        padding: const EdgeInsets.all(10.0),
        itemCount: _peopleList.length,
        itemBuilder: (context, index) {
          return ListTile(
            title: Text(_peopleList[index]["name"]),
            trailing: Icon(Icons.star),
          );
        });
  }
}
