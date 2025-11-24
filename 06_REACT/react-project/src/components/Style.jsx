import React from 'react'
import './Style.css'
import styled from 'styled-components'

const roundBoxStyle = {
    position: "absolute",
    top: 50,
    left: 50,
    width: 200,
    height: 200,
    backgroundColor: "skyblue",
    borderRadius: 50,
    color: "white",
}

const RoundBox = styled.div`
    position: absolute;
    top: ${props => props.top || 50}px;
    left: 50px;       
    width: 200px;
    height: 200px;
    background-color: skyblue;
    border-radius: 50px;
    color: white;
`

const Style = () => {
  return (
    <>
        <h3>1. Object로 css 작성</h3>
        <p>인라인 속성이며 재사용성이 떨어지고 코드 복잡도가 떨어진다</p>
        <div style={{
            position: "relative",
            width: "400px",
            height: "1500px",
            backgroundColor: "lightgray"
        }}>
            <h3>2. css-in-js로 스타일을 직접 작성</h3>
            <div style={roundBoxStyle}>
                <p>
                    재사용이 가능하고 코드가 깔끔해진다.
                    기존 css 기능 사용이 불가능하고 체계적이지 못하다.
                </p>
                <p className="highlight">class를 활용</p>
            </div>
            <div style={{...roundBoxStyle, top: 300}}>
                <p>
                    3. 조건부 스타일 가능
                </p>
                <p className={1+1 !== 2 && "highlight"}>class를 활용</p>
            </div>
            <RoundBox top={600}>
                <p> 4. styled-components</p>
                <p> 
                    js 안에서 css 문법 그대로 스타일을 작성할 수 있게 해주는 라이브러리이다.
                    특정 css가 적용된 새로운 컴포넌트를 만들어 코드의 재사용성을 높여주고,
                    class명 충돌 걱정없이 사용이 가능하다.
                </p>
            </RoundBox>
            <RoundBox top={600}>
                <p> 4. styled-components</p>
                <p> 
                    js 안에서 css 문법 그대로 스타일을 작성할 수 있게 해주는 라이브러리이다.
                    특정 css가 적용된 새로운 컴포넌트를 만들어 코드의 재사용성을 높여주고,
                    class명 충돌 걱정없이 사용이 가능하다.
                </p>
            </RoundBox>
        </div>
    </>
  )
}

export default Style