import 'package:flutter/material.dart';
import 'package:starwars_app/pages/people-page.dart';
import 'package:starwars_app/pages/planets-page.dart';
import 'package:starwars_app/pages/starships-page.dart';

class Tabs extends StatelessWidget {

  Widget build(BuildContext context) {
    return DefaultTabController(
        length: 3,
        child: Scaffold(
          appBar: AppBar(
            bottom: TabBar(
              tabs: [
                Tab(text: 'People'),
                Tab(text: 'Planets'),
                Tab(text: 'Starships'),
              ],
            ),
            title: Text('Star wars'),
          ),
          body: TabBarView(
            children: [
              PeoplePage(),
              Planets(),
              Starships(),
            ],
          ),
        ),
    );
  }
}