import React, {useState, useEffect} from 'react';
import {View, Text} from 'react-native';
import {FlatList} from 'react-native-gesture-handler';

import api from '../../services/api';

import styles from '../../styles';
import ListItem from '../../components/ListItem';

export default function Planets() {
  const [planets, setPlanets] = useState('');
  const [page, setPage] = useState(2);

  useEffect(() => {
    async function loadInitialData() {
      const response = await api.get('/planets');

      if (response.data.results) {
        setPlanets(response.data.results);
      }
    }

    loadInitialData();
  }, []);

  async function loadMore() {
    const response = await api.get(`/planets/?page=${page}`);

    if (response.data.results) {
      const newList = planets.concat(response.data.results);

      setPlanets(newList);
      setPage(page + 1);
    }
  }

  return (
    <View>
      <FlatList
        style={styles.list}
        data={planets}
        keyExtractor={planet => `${planet.name}`}
        renderItem={({item}) => (
          <ListItem
            item={item}
            disabledFields={[
              'name',
              'edited',
              'url',
              'created',
              'residents',
              'films',
            ]}
          />
        )}
        onEndReached={loadMore}
        onEndReachedThreshold={0.3}
      />
    </View>
  );
}
