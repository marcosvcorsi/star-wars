import 'package:flutter/material.dart';
import 'package:sw_app/pages/people_page.dart';
import 'package:sw_app/pages/planets_page.dart';
import 'package:sw_app/pages/starships_page.dart';

class HomePage extends StatefulWidget {
  @override
  _HomePageState createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return DefaultTabController(
      length: 3,
      child: Scaffold(
        appBar: AppBar(
          title: Text("Star Wars"),
          centerTitle: true,
          bottom: TabBar(
            tabs: <Widget>[
              createTab("People"),
              createTab("Planets"),
              createTab("Starships")
            ],
          ),
        ),
        body: TabBarView(
          children: <Widget>[
            PeoplePage(),
            PlanetsPage(),
            StarshipsPage()
          ],
        ),
      ),
    );
  }
}

Widget createTab(String text) {
  return Container(
    padding: const EdgeInsets.all(10.0),
    child: Text(
      text
    ),
  );
}
