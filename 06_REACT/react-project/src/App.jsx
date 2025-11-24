import { useState } from 'react'
import JavaScript from './components/JavaScript' // default import이므로 가능하다.
import './App.css'
import Style from './components/Style'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      {/*<JavaScript />*/}
      <Style />
    </>
  )
}

export default App
