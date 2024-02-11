import React from "react";
import MainCarousel from "../component/HomeCarousel/MainCarousel";
import HomeSectionCarousel from "../component/HomeCarousel/HomeSectionCarousel";

const HomePage = () => {
  return (
    <div>
      <MainCarousel />
      <div><HomeSectionCarousel/></div>
    </div>
  );
};

export default HomePage;
