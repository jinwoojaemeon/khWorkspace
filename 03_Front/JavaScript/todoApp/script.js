/**
 * localStorage 객체
 * - 브라우저에 key-value 형태로 데이터를 저장할 수 있는 공간
 * - 저장된 데이터는 브라우저를 껐다 켜도 유지가 되며, 도메인 별로 저장이 된다.
 * - 최대 저장 용량은 5MB(브라우저별로 다를 수 있다.)
 *  localStorage.setItem(key, value); - 데이터를 저장 
    localStorage.getItem(key); - 데이터를 불러올 때
    localStorage.removeItem(key) - 데이터를 삭제할 때
    localStorage.clear() - 모든 데이터 삭제
    * 문자열만 저장하고 가져올 수 있다.

    JSON.stringify(js객체) -> JSON 문자열로 변환
    JSON.parse(문자열) -> JS 객채로 복원
 */

// ============= 전역 변수 =============
// 할 일 목록을 저장하는 배열 - 여러 함수에서 공유해야 하기 때문에 전역 선언
let todos = JSON.parse(localStorage.getItem('todos'))||[];  // 로컬 저장소에서 불러오거나, 비어있다면 빈칸
let filterState = 'all';    // 필터 버튼 '전체'로 초기값 설정

// ============= DOM  요소 =============
const todoList = document.getElementById('todo-list');   // 할일 목록 
const todoInput = document.getElementById('todo-input');  // todo 입력창 
const clearCompletedBtn = document.getElementById('clear-btn'); // 완료목록삭제버튼
const filterBtns = document.querySelectorAll('.filter-buttons button');  // 필터 버튼 목록

// ============ 초기화 함수 ============
// 웹이 시작될 때 실행되는 기본함수
// 이벤트 등록과 화면 렌더링을 담당
function init(){
    bindEvents();    // 기본적으로 있어야하는 Event를 모두 반환?
    render();        // 화면 렌더링 (화면 출력 함수화)
}

function bindEvents(){  
    const addBtn = document.getElementById('todo-add-btn');
    addBtn.addEventListener('click', addTodo);  // 추가 버튼 onclick 이벤트 등록

    todoInput.addEventListener('keydown', function(e){  // 추가 버튼을 e(event).key로 엔터키 누를 시 추가 버튼 누른 것 처럼 만드는 함수
        if(e.key === 'Enter'){
            addTodo();
        }
    })

    clearCompletedBtn.addEventListener('click', clearCompletedTodos);  // 완료한 할 일 목록들 모두 제거하는 이벤트 등록

    //필터 버튼들을 가져와서 이벤트를 등록 
    filterBtns.forEach(function(btn){ // 필터 버튼 이벤트 등록 
        btn.addEventListener('click', function(ev){ // 버튼 클릭 이벤트 발생 시 setFilter 적용
           setFilter(ev.target.dataset.filter); 
        });
    })
}

// ========== 데이터 조작 함수 ==========
//새로운 할일을 추가하는 함수
function addTodo(){  
    const text = todoInput.value.trim();  // 전역 변수로 지정해둔 DOM 요소 document.getElementById('todo-input');의 공백 제거 
    if(!text) return;   // if(text === "") return; 
                        // 빈 문자열이면 함수 종료
    const todo = {                       // 할 일 객체화
        id: Date.now(), // 현재시간을 ms단위로 변환 ->  고유한 ID로 사용 >> sql에서 sequence 역할을 대신하고 있다. 
        contents: text,   // 사용자가 적은 할 일 
        completed: false, // 완료 상태 초기값: false
        createdAt: new Date().toLocaleString(), // 생성시간이 저장 
    }

    todos.push(todo); // 새로운 할 일 추가
    todoInput.value = "";     // <input id="todo-input" type="text" placeholder="새로운 할일을 입력하세요."> 비도록 만듦
    //console.log(todos);
    // 할일 목록을 기준으로 UI에 적용
    saveTodos();     // 로컬 저장소에 저장 
    render();    // 화면 렌더링 
}

// 등록된 할일을 삭제하는 함수 
function deleteTodo(id){
    // 해당 ID를 목록에서 제거
    let newTodo = [];   // 삭제할 할일을 포함하지 않은 새로운 todos로 덮어쓰기 위한 빈 리스트 생성
    for(let todo of todos){
        if(todo.id === id) continue;  // 삭제할 할 일의 id와 같으면 

        newTodo.push(todo);           // newTodo에 추가하지 않는다.
    }

    todos = newTodo;  // 삭제한 할일을 push하지 않은 리스트로 기존 할일 목록 덮어쓰기 
    saveTodos();    // 로컬 저장소에 저장  
    render();      // 화면 렌더링 
}

// 할일 체크박스 토글버튼화 해주는 함수 
function toggleTodo(id){    
    // 해당 ID를 통해서 할 일을 찾아서 완료 상태 -> 미완료, 미완료-> 완료 변경
    for(let todo of todos){    
        if(todo.id === id) {     // 체크박스를 누른 할일의 id라면 
            todo.completed = !todo.completed;   // 체크 박스의 상태를 반대로 만든다. (완료 -> 미완료, 미완료-> 완료)
            break;  // 바꿨으므로 더이상 확인하는 것은 의미가 없으니 반복 종료 
        }
        
    }
    saveTodos();   // 로컬 저장소에 저장 
    render();   // 화면 렌더링 
}

// 완료 상태인(체크박스가 활성화 상태인) 할 일들 일괄 제거하는 함수  
function clearCompletedTodos(){   
    let newTodos = [];   // 삭제할 할일을 포함하지 않은 새로운 todos로 덮어쓰기 위한 빈 리스트 생성
     for(let todo of todos){ 
        if(!todo.completed){  // 체크가 되어있지 않은 할 일이면?
            newTodos.push(todo);    // 완료되지 않은 목록에 추가
        }
    }
    todos = newTodos;   // 기존 todos에 덮어쓰기
    saveTodos();  // 로컬 저장소에 저장
    render(); // 화면 업데이트
}

// 현재 필터에 따라서 할 일 목록을 필터링하여 보여주는 함수
function getFilteredTodos(){
    const filteredTodos = [];   // 필터에 적합한(?걸러진?) 할 일 목록만 보이기 위한 덮어쓰기 위한 빈 리스트 생성 
    if(filterState === 'active'){      // filterState(현재 눌러진 필터버튼)가 'active(미완료)' 상태라면
        // 미완료 목록만 filteredTodos에 담기
        for(let todo of todos){   
            if(!todo.completed){   // 체크박스가 눌러져있지 않은 할일들만 리스트에 push
                filteredTodos.push(todo);
            }
        }
    }else if(filterState === 'completed'){    // filterState(현재 눌러진 필터버튼)가 'completed(완료)' 상태라면
        // 완료 목록만 filteredTodos에 담기
        for(let todo of todos){
            if(todo.completed){   // 체크박스가 눌려진 할일들만 리스트에 push
                filteredTodos.push(todo);
            }
        }
    }else{  // 완료/미완료가 아니면 'all(전체)' 이기에
        return todos;   // 덮어쓰기가 필요없이 리턴
    }
    return filteredTodos; // '전체'가 아니면 필터에 걸러진 할일 리스트 리턴
}

function saveTodos(){
     localStorage.setItem('todos', JSON.stringify(todos)); // todos를 key-value 형태로 만들어 저장
}

// =========== 화면 렌더링을 위한 함수 =============
// 메인 렌더링 함수
function render(){
    todoList.innerHTML = ""; // 기존 UI 제거

    // 현재 필터에 맞는 할일만 목록으로 가져오기
    const filteredTodos = getFilteredTodos();


    if(filteredTodos.length === 0){ // 필터링 된 할 일 목록이 비어있다면 
        emptyStateRender();  //  빈 상태의 렌더링 
    } else { // 할일 목록이 있는 경우 
        filteredTodos.forEach(function(todo){ // 목록의 전체를 렌더링 시키기
            todoItemRender(todo);
        })
    }

    updateCount();  // 할 일 목록 갯수 표시
    updateClearButton()  // '완료된 항목 삭제' 버튼 활성화 여부를 정해서 표시
}

function emptyStateRender(){    // 할일 목록이 비어있을 경우 화면 출력 관련 함수 
    const emptyE1 = document.createElement('div'); // 새로운 요소:div(영역) 생성
    emptyE1.className = 'empty-state';      // 생성한 요소의 클래스 이름 지정
    emptyE1.innerHTML = '등록된 할 일이 없습니다.';   // 해당 요소가 표시할 내용 
    todoList.appendChild(emptyE1);   // 할일 목록에 자식요소로 추가하여 화면에 출력하도록 유도
}

function todoItemRender(todo){  // todoList에 할일 요소를 추가하고 출력시키는 함수?
    const todoItem = document.createElement('li');    // ul 영역(<ul id="todo-list" class="todo-list">) 안에 새로운 li 생성
    todoItem.className = 'todo-item' + (todo.completed ? ' completed' : ''); // 체크박스 상태에 따라 보이는 체크박스 css 상대 다르게.

    todoItem.innerHTML = `<div class="todo-checkbox ${todo.completed ? 'checked' : ''}"></div>  
                            <span>${todo.contents}</span>
                            <button class="delete-btn">삭제</button>`;    // 새로운 할일 표시 
                            
    //새로 생성된 요소들 중에서 이벤트가 필요한 부분만 가져오기.
    const checkbox = todoItem.querySelector('.todo-checkbox'); // todoItem내부에 있는 checkbox요소
    checkbox.addEventListener('click', function(){  // checkbox 박스의 클릭 이벤트 추가
        toggleTodo(todo.id);   // toggle 형태로 제작한 체크박스 상태 변경 (완료->미완료||미완료->완료)
    })

    const deleteBtn = todoItem.querySelector('.delete-btn');  // todoItem 내부에 있는 deleteBtn요소
    deleteBtn.addEventListener('click', function(){  // 삭제 버튼의 클릭 이벤트 추가 
        deleteTodo(todo.id);    // 눌러진 영역의 할일을 todos리스트에서 삭제
    })
    todoList.appendChild(todoItem);   // 추가되거나 삭제된 할일 목록을 최종적으로 DOM 트리에 업데이트
}

// 남은 할 일의 개수를 구해서 화면을 업데이트하는 함수
function updateCount(){ 
    const todoCnt = document.getElementById('todo-count');  // (<span id="todo-count">0개 남음</span>) 영역에 넣을것임.
    let count = 0;   
    for(let todo of todos){
        if(!todo.completed) count++;     // 체크가 안 된 할 일 (완료하지 않은 할일)의 개수 세기
    }
    if(count===0){        // span 영역에 표현 (할 일이 없을 때)
        todoCnt.innerHTML = `모든 할 일을 마쳤다.`; 
    }else{              // 할일이 있다면 몇 개인지 표현
        todoCnt.innerHTML = `할 일이 ${count}개 남아있다.`;
    }
    
}

 // '완료된 항목 삭제' 버튼 활성화 여부를 결정하는 함수
function updateClearButton(){    // clear 버튼 
    let isView = 'none';  // 초기 값은 보이지 않게 설정 (체크한 항목이 없다는 것이 기본값)
    for(let todo of todos){   
        if(todo.completed){   // 완료가 된 할 일이 있다면 
            isView = 'block';  // 버튼이 보이도록 설정 
            break; // 보이도록 했으니 더 체크가 됐든 말든 반복문 종료하면 된다.
        }
    }

    // 완료된 목록이 있다면 버튼 표시, 없으면 숨김
    clearCompletedBtn.style.display = isView;  // isView에 따라 활성화 여부 결정
}

// ========= 필터 관련 함수 ===========
//필터를 설정하고 UI를 업데이트하는 함수
function setFilter(filter){
    filterState = filter; // 전역 상태에 필터 상태를 변경

    // 모든 필터 버튼의 active클래스를 조회해서 수정
    filterBtns.forEach(function(btn){  //버튼 클릭 이벤트 발생 시 누른 버튼일 경우 className을 active로, 아니라면 ""으로 설정 
        btn.className = (btn.dataset.filter === filter ? "active" : "");   // >> 토글 버튼처럼 설정되는 효과가 있다
    });

    render();  // 필터링 상태 변경이 되었으므로 화면 렌더링
}

// ========= load 이벤트 함수 =========
// window.onload = function(){
//     init();
// }

// DOMContentLoaded -> HTML이 전부 로드되어 DOM트리가 완성되면 실행
document.addEventListener('DOMContentLoaded', init);