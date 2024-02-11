import React from "react";
import AliceCarousel from "react-alice-carousel";
import { HomeKurtaData } from "../../Data/HomeKurtaData";
import HomeSectionCard from "../HomeSectionCard/HomeSectionCard";

const HomeSectionCarousel = ({ items, header }) => {
  const responsive = {
    0: { items: 1 },
    720: { items: 3 },
    1024: { items: 4.5 },
  };
  const KurtaItem = items.map((item) => <HomeSectionCard items={item} />);
  return (
    <div className="border">
      <h2 className="text-2xl font-extrabold text-gray-800 py-5 ml-5">
        {header}
      </h2>
      <div className="relative p-5">
        <AliceCarousel
          autoPlay
          autoPlayStrategy="default"
          responsive={responsive}
          autoPlayInterval={1000}
          animationDuration={1000}
          animationType="fadeout"
          disableDotsControls
          items={KurtaItem}
        />
      </div>
    </div>
  );
};

export default HomeSectionCarousel;
