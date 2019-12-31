import 'package:flutter/material.dart';
import 'package:sw_app/api/sw_api.dart';

class PlanetsPage extends StatefulWidget {
  @override
  _PlanetsPageState createState() => _PlanetsPageState();
}

class _PlanetsPageState extends State<PlanetsPage> {
  List _planetList = List();
  int _page = 1;

  @override
  void initState() {
    super.initState();

    this._loadData();
  }

  void _loadData() async {
    Map<String, dynamic> data = await SWApi.get(endpoint: "planets", page: _page);

    setState(() {
      _planetList = data["results"];
    });
  }

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        padding: const EdgeInsets.all(10.0),
        itemCount: _planetList.length,
        itemBuilder: (context, index) {
          return ListTile(
            title: Text(_planetList[index]["name"]),
            trailing: Icon(Icons.star),
          );
        });
  }
}
