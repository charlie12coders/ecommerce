import React from "react";
import { HomeCarouselData } from "../../Data/HomeCarouselData";
import AliceCarousel from "react-alice-carousel";
import "react-alice-carousel/lib/alice-carousel.css";

const MainCarousel = () => {
  const items = HomeCarouselData.map((item) => (
    <img
      className="cursor-pointer object-cover"
      role="presentation"
      src={item.image}
    />
  ));
  return (
    <AliceCarousel
      autoPlay
      autoPlayStrategy="default"
      infinite
      autoPlayInterval={1000}
      animationDuration={1000}
      animationType="fadeout"
      disableButtonsControls
      disableDotsControls
      items={items}
    />
  );
};

export default MainCarousel;
