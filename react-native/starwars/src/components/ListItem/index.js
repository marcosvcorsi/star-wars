import React from "react";
import { View, Text } from "react-native";

import styles from "./styles";

export default function ListItem({ item }) {
  return (
    <View style={styles.listItem}>
      <Text style={styles.descriptionText}>{item.name}</Text>
    </View>
  );
}
