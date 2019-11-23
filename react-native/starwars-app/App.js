import React, { useEffect } from "react";
import { StatusBar } from "react-native";

import Routes from "./src/routes";
import Header from "./src/components/Header";

import * as Font from "expo-font";

export default function App() {
  useEffect(() => {
    async function loadFont() {
      await Font.loadAsync({
        // prettier-ignore
        'star_wars': require("./assets/fonts/star_wars.TTF")
      });
    }

    loadFont();
  }, []);

  return (
    <>
      <StatusBar hidden />
      <Header />
      <Routes />
    </>
  );
}
