import React, { useState, useEffect } from "react";
import { View, Text } from "react-native";
import { FlatList } from "react-native-gesture-handler";

import api from "../../services/api";

import styles from "../../styles";
import ListItem from "../../components/ListItem";

export default function Planets() {
  const [result, setResult] = useState("");

  useEffect(() => {
    async function loadData() {
      const response = await api.get("/planets");

      if (response.data) {
        setResult(response.data);
      }
    }

    loadData();
  }, []);

  return (
    <View>
      <FlatList
        style={styles.list}
        data={result.results}
        keyExtractor={planet => `${planet.url}`}
        renderItem={({ item }) => <ListItem item={item} />}
      />
    </View>
  );
}
