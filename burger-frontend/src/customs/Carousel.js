import React from 'react';
import Slider from 'react-slick';
import { NextArrow, PrevArrow } from './CustomArrow';
import 'slick-carousel/slick/slick.css';
import 'slick-carousel/slick/slick-theme.css';
import '../css/customs/carousel.css';

const Carousel = () => {
  // <Slider {...settings}>
  //     <img src={require('../img/test1.png')} alt="slide1"></img>
  //     <img src={require('../img/test2.png')} alt="slide2"></img>
  //     <img src={require('../img/test3.png')} alt="slide3"></img>
  //     <img src={require('../img/test4.png')} alt="slide4"></img>
  //   </Slider>

  const images = [
    { src: require('../img/slide1.png') },
    { src: require('../img/slide2.png') },
    { src: require('../img/slide3.png') },
    { src: require('../img/slide4.png') },
  ];

  const settings = {
    dots: false,
    arrow: true,
    infinite: true,
    speed: 500,
    autoplay: true,
    autoplaySpeed: 4000,
    nextArrow: <NextArrow className="slick-next" />,
    prevArrow: <PrevArrow className="slick-prev" />,
  };
  return (
    <div className="carousel">
      <Slider {...settings}>
        {images.map((image, index) => (
          <div key={index}>
            <img src={image.src} alt={`slide ${index + 1}`} />
          </div>
        ))}
      </Slider>
    </div>
  );
};

export default Carousel;
