import React from "react";
import AliceCarousel from "react-alice-carousel";
import { HomeKurtaData } from "../../Data/HomeKurtaData";
import HomeSectionCard from "../HomeSectionCard/HomeSectionCard";

const HomeSectionCarousel = () => {
  const responsive = {
    0: { items: 1 },
    720: { items: 3 },
    1024: { items: 4.5 },
  };
  const items = HomeKurtaData.map((item) => <HomeSectionCard item={item} />);
  return (
    <AliceCarousel
      autoPlay
      responsive={responsive}
      autoPlayInterval={1000}
      animationDuration={1000}
      animationType="fadeout"
      disableButtonsControls
      disableDotsControls
      items={items}
    />
  );
};

export default HomeSectionCarousel;
