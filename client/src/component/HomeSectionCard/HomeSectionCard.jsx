import React from "react";

const HomeSectionCard = ({ items }) => {
  return (
    <div className="cursor-pointer flex flex-col items-center bg-white rounded-lg shadow-lg overflow-hidden w-[15rem] mx-3">
     
      <div className="h-[13rem] w-[10rem]">
        <img
          className="object-cover object-top w-full h-full"
          src={items.image}
          alt=""
        />
      </div>
      <div className="p-4">
        <h3 className="text-lg font-medium text-gray-900">{items.brand}</h3>
        <p className="mt-2 text-sm text-gray-900">{items.title}</p>
      </div>
    </div>
  );
};

export default HomeSectionCard;
