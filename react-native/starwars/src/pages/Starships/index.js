import React, {useState, useEffect} from 'react';
import {View} from 'react-native';
import {FlatList} from 'react-native-gesture-handler';

import api from '../../services/api';

import styles from '../../styles';
import ListItem from '../../components/ListItem';

export default function Starships() {
  const [starships, setStarships] = useState([]);
  const [page, setPage] = useState(2);

  useEffect(() => {
    async function loadInitialData() {
      const response = await api.get('/starships');

      if (response.data.results) {
        setStarships(response.data.results);
      }
    }

    loadInitialData();
  }, []);

  async function loadMore() {
    const response = await api.get(`/starships/?page=${page}`);

    if (response.data.results) {
      const newList = starships.concat(response.data.results);

      setStarships(newList);
      setPage(page + 1);
    }
  }

  return (
    <View>
      <FlatList
        style={styles.list}
        data={starships}
        keyExtractor={st => `${st.url}`}
        onEndReached={loadMore}
        onEndReachedThreshold={0.3}
        renderItem={({item}) => (
          <ListItem
            item={item}
            disabledFields={[
              'name',
              'edited',
              'url',
              'created',
              'films',
              'pilots',
            ]}
          />
        )}
      />
    </View>
  );
}
