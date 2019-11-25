import {createAppContainer} from 'react-navigation';
import {createMaterialTopTabNavigator} from 'react-navigation-tabs';

import People from './pages/People';
import Planets from './pages/Planets';
import Starships from './pages/Starships';

const tabNavigator = createMaterialTopTabNavigator(
  {
    People,
    Planets,
    Starships,
  },
  {
    tabBarOptions: {
      style: {
        backgroundColor: '#000',
      },
      labelStyle: {
        fontFamily: 'SFDistantGalaxy',
      },
    },
  },
);

export default createAppContainer(tabNavigator);
