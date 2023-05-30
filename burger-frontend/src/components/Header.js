import React, { useEffect, useState } from 'react';
import '../css/components/header.css';
import { Link, useNavigate } from 'react-router-dom';

const Header = () => {
  const [submenu, setSubmenu] = useState(true);
  const navigate = useNavigate();

  const hiddenSubmenu = submenu ? 'none' : 'block';

  // const moveToInquiry = () => {
  //   navigate('/inquiry');
  // };

  // const handleClick = (e) => {
  //   if (e.target.name === 'inquiry') {
  //     navigate('/inquiry');
  //   }
  //   if (e.target.name === 'signin') {
  //     navigate('/signin');
  //   }
  //   if (e.target.name === 'signup') {
  //     navigate('/signup');
  //   }
  // };

  // 버튼 클릭시 Link로 이동
  const handleClick = (e) => {
    switch (e.target.name) {
      case 'inquiry':
        navigate('/inquiry');
        break;
      case 'signin':
        navigate('/signin');
        break;
      case 'signup':
        navigate('/signup');
        break;

      default:
        break;
    }
  };

  useEffect(() => {}, [submenu]);

  return (
    <>
      <div className="header">
        <div className="header-container">
          <Link to={'/'} className="logo">
            <img src={require('../img/logo.jpg')} alt="logo" className="header-logo"></img>
          </Link>
          <ul className="nav-bar" onMouseOver={() => setSubmenu(!hiddenSubmenu)}>
            <Link to={'/menu'} className="header-menu header-link">
              메뉴소개
            </Link>
            <Link to={'/store'} className="header-store header-link">
              매장소개
            </Link>
            <Link to={'/event'} className="header-event header-link">
              이벤트
            </Link>
            <Link to={'mypage'} className="header-mypage header-link">
              마이페이지
            </Link>
          </ul>
          <div className="nav-button">
            <button className="header-inquiry" onClick={handleClick} name="inquiry">
              가맹점 문의
            </button>
            <div className="header-login-group">
              <button className="header-signin" onClick={handleClick} name="signin">
                로그인
              </button>
              <button className="header-signup" onClick={handleClick} name="signup">
                회원가입
              </button>
            </div>
          </div>
        </div>
      </div>

      {/* dropdown menu */}

      <div
        className="header-dropdown"
        onMouseLeave={() => setSubmenu(hiddenSubmenu)}
        style={{ display: hiddenSubmenu }}
      >
        <div className="header-dropdown-container">
          <ul className="header-dropdown-submenu">
            <li className="submenu-link">추천메뉴</li>
            <li className="submenu-link">햄버거</li>
            <li className="submenu-link">사이드</li>
            <li className="submenu-link">디저트</li>
          </ul>
          <ul className="header-dropdown-submenu">
            <Link to={'/store'} className="submenu-link">
              매장 찾기
            </Link>
          </ul>
          <ul className="header-dropdown-submenu">
            <Link to={'/event'} className="submenu-link">
              이벤트
            </Link>
          </ul>
          <ul className="header-dropdown-submenu">
            <Link to={'/mypage'} className="submenu-link">
              회원 정보
            </Link>
          </ul>
        </div>
      </div>
    </>
  );
};

export default Header;
