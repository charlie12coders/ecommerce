import React from "react";
import MainCarousel from "../component/HomeCarousel/MainCarousel";
import HomeSectionCarousel from "../component/HomeCarousel/HomeSectionCarousel";
import { HomeKurtaData } from "../Data/HomeKurtaData";
import { LehangaCholiData } from "../Data/LehangaCholiData";
import { MenJeansData } from "../Data/MenJeansData";

const HomePage = () => {
  return (
    <div>
      <MainCarousel />
      <div className="space-y-10 py-20 flex flex-col justify-center px-5 lg:px-10">
        <HomeSectionCarousel items={HomeKurtaData} header={"Women's Kurta"} />
        <HomeSectionCarousel
          items={LehangaCholiData}
          header={"Women's Dress"}
        />
        <HomeSectionCarousel
          items={MenJeansData}
          header={"Men's Jeans Dress"}
        />
      </div>
    </div>
  );
};

export default HomePage;
