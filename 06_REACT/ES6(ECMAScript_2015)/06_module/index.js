// utils.js에서 작성한 기능을 import를 통해 가져와서 사용 가능하다.

import { add, PI } from "./utils.js";
import helloFunc from "./utils.js";

console.log("2 + 3 = ", add(2, 3));
console.log("PI = ", PI);

helloFunc("Jeameon");

// 모듈 시스템에서는 각 파일에 독립된 scope를 제공한다.
// 다른 파일의 변수나 함수는 반드시 import를 통해 가져와서 사용한다.

