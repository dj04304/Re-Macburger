import React from 'react';
import '../css/pages/home.css';
import Carousel from './../customs/Carousel';
import { Link, useNavigate } from 'react-router-dom';

const Home = () => {
  const navigate = useNavigate();

  const rescMenus = [
    { src: require('../img/product/bulgogi.png'), name: '불고기 버거' },
    { src: require('../img/product/1955.png'), name: '1955 버거' },
    { src: require('../img/product/chiken.png'), name: '치킨 버거' },
  ];

  // { src: require('../img/test1.png') },
  // { src: require('../img/test2.png') },
  // { src: require('../img/test3.png') },
  // { src: require('../img/test4.png') },

  return (
    <>
      <div className="main-container">
        <Carousel></Carousel>

        {/* video */}
        <iframe
          width="560"
          height="315"
          src="https://www.youtube.com/embed/85jrGITDPHc"
          title="YouTube video player"
          frameborder="0"
          allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
          allowfullscreen
          className="burger-video"
        ></iframe>

        {/* menu */}
        <div className="recs-menu">
          <h1 className="resc-title">Mac's 추천 메뉴</h1>
          <ul className="recs-menu-group">
            {rescMenus.map((rescMenu, index) => (
              <Link className={`resc-menu-list`}>
                <img src={rescMenu.src} alt={`rescMenu ${index + 1}`} name={rescMenu.name} />
                <p className="resc-menu-name">{rescMenu.name}</p>
              </Link>
            ))}
          </ul>
        </div>
        {/* store */}
        <div className="main-store">
          <div className="main-store-content">
            <h1 className="main-store-title">매장찾기</h1>
            <h3 className="main-store-text">주변에 있는 Mac버거를 찾아보세요!</h3>
            <button className="main-store-btn" type="button" onClick={() => navigate('/store')}>
              매장찾기
            </button>
          </div>
        </div>
      </div>
    </>
  );
};

export default Home;
