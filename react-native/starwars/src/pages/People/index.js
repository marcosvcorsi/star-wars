import React, {useState, useEffect} from 'react';
import {View, Text} from 'react-native';
import {FlatList} from 'react-native-gesture-handler';

import api from '../../services/api';

import styles from '../../styles';
import ListItem from '../../components/ListItem';

export default function People() {
  const [people, setPeople] = useState([]);
  const [page, setPage] = useState(2);

  useEffect(() => {
    async function loadInitialData() {
      const response = await api.get('/people');

      if (response.data.results) {
        setPeople(response.data.results);
      }
    }

    loadInitialData();
  }, []);

  async function loadMore() {
    const response = await api.get(`/people/?page=${page}`);

    if (response.data.results) {
      const newList = people.concat(response.data.results);

      setPeople(newList);
      setPage(page + 1);
    }
  }

  return (
    <View>
      <FlatList
        style={styles.list}
        data={people}
        keyExtractor={pl => `${pl.name}`}
        renderItem={({item}) => (
          <ListItem
            item={item}
            disabledFields={[
              'name',
              'edited',
              'url',
              'created',
              'starships',
              'vehicles',
              'species',
              'films',
              'homeworld',
            ]}
          />
        )}
        onEndReached={loadMore}
        onEndReachedThreshold={0.3}
      />
    </View>
  );
}
