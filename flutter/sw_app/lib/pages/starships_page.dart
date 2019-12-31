import 'package:flutter/material.dart';
import 'package:sw_app/api/sw_api.dart';

class StarshipsPage extends StatefulWidget {
  @override
  _StarshipsPageState createState() => _StarshipsPageState();
}

class _StarshipsPageState extends State<StarshipsPage> {
  List _starshipList = List();
  int _page = 1;

  @override
  void initState() {
    super.initState();

    this._loadData();
  }

  void _loadData() async {
    Map<String, dynamic> data = await SWApi.get(endpoint: "starships", page: _page);

    setState(() {
      _starshipList = data["results"];
    });
  }

  @override
  Widget build(BuildContext context) {
    return ListView.builder(
        padding: const EdgeInsets.all(10.0),
        itemCount: _starshipList.length,
        itemBuilder: (context, index) {
          return ListTile(
            title: Text(_starshipList[index]["name"]),
            trailing: Icon(Icons.star),
          );
        });
  }
}
