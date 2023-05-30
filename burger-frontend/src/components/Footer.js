import React from 'react';
import '../css/components/footer.css';
import { useNavigate } from 'react-router-dom';

const Footer = () => {
  const navigate = useNavigate();

  return (
    <>
      <div className="footer">
        <div className="footer-group">
          <div className="footer-content-group">
            <h3 className="footer-title">MacBurger</h3>
            <div className="footer-text">
              <p>부산 연제구 00로 00타워 0층 주식회사 000</p>
              <p>전화주문 1234-1234</p>
              <p>사업자 등록번호 000-12-123456</p>
              <p>(주)맥버거 대표 박준형</p>
            </div>
          </div>
          <div className="footer-right-menu">
            <ul className="footer-terms-group">
              <li>
                이용약관 <span className="border-hidden-span"></span>
              </li>
              <li>
                개인정보 처리방침<span className="border-hidden-span"></span>
              </li>
              <li>법적고지</li>
            </ul>
            <div className="footer-btn-group">
              <button type="button">인재채용</button>
              <button type="button" onClick={() => navigate('/inquiry')}>
                가맹점모집
              </button>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Footer;
