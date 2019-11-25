import React, {useState} from 'react';
import {View, Text, TouchableOpacity} from 'react-native';
import Icon from 'react-native-vector-icons/FontAwesome';
import {ToastAndroid} from 'react-native';

import styles from './styles';

export default function ListItem({item, disabledFields}) {
  const [favorite, setFavorite] = useState(false);
  const [expand, setExpand] = useState(false);

  function handleFavorite(pressed) {
    setFavorite(!favorite);

    if (!favorite) {
      ToastAndroid.showWithGravityAndOffset(
        `${pressed.name} was added to favorites`,
        ToastAndroid.SHORT,
        ToastAndroid.BOTTOM,
        25,
        50,
      );
    }
  }

  function handleExpand() {
    setExpand(!expand);
  }

  return (
    <View style={styles.listItem}>
      <Text style={styles.descriptionText} onPress={handleExpand}>
        {item.name}
      </Text>

      <TouchableOpacity
        style={styles.favoriteButton}
        onPress={() => handleFavorite(item)}>
        <Icon name="star" size={32} color={favorite ? '#000' : '#999'} />
      </TouchableOpacity>
      {expand && (
        <View
          onStartShouldSetResponder={handleExpand}
          style={styles.contentView}>
          {Object.keys(item)
            .filter(prop => !disabledFields.includes(prop))
            .map(it => (
              <Text key={it} style={styles.itemText}>
                {it.replace(new RegExp('_', 'g'), ' ')}: {item[it]}
              </Text>
            ))}
        </View>
      )}
    </View>
  );
}
