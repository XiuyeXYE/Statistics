

xy((e)=>{
	
	
	
//	let pages = ['signInPage','registerPage','fbkPage'];
	let pageM = new Map();
	pageM.set('/signInPage',{panel:'login',active:'l'});
	pageM.set('/registerPage',{panel:'reg',active:'r'});
	pageM.set('/fbkPage',{panel:'fbk',active:'f'});
	
	
	
	let lis = xy('#navigator li');
	lis.click((e)=>{
		let li = xy.Dom.of(e.target).parent();
		console.log(li);
		for(let p of pageM){
			let pageName = p[0];
			let pageInfo = p[1];
			if(li.data('name') == pageInfo.active){
				xy("#"+pageInfo.panel).cls('hide',false);
				li.cls('active');
				xy.OPR.push(null,null,pageName);
			}else{
				xy("#"+pageInfo.panel).cls('hide');
				xy("#navigator li[data-name="+pageInfo.active+"]").cls('active',false);
			}
		}
	},true/*onclick*/);
	
	function recovery(){
		let path = location.pathname;
		for(let p of pageM){
			
			let pageName = p[0];
			let pageInfo = p[1];
			if(path == pageName){
				xy("#"+pageInfo.panel).cls('hide',false);
				xy("#navigator li[data-name="+pageInfo.active+"]").cls('active');
			}else{
				xy("#"+pageInfo.panel).cls('hide');
				xy("#navigator li[data-name="+pageInfo.active+"]").cls('active',false);
			}
		}
	}
	
	recovery();
	
	xy.OPR.add((e)=>{
//		console.log(e);
		recovery();
	});
	
	let loginPanel = xy("#login");
	let regPanel = xy("#reg");
	let fbkPanel = xy("#fbk");
	
	let ps = new Map();
	ps.set('login',loginPanel);
	ps.set('reg',regPanel);
	ps.set('fbk',fbkPanel);
	
	function showPanel(id){
		for(let p of ps){
			p[1].cls('hide',p[0]!=id);
		}
	}
	
	let regBtn = xy.d("#register");
	
	regBtn.click((e)=>{
		showPanel('reg');
		let an = regBtn.data('active');
		let lis = xy.d('#navigator li');
		lis.forEach((d)=>{
			let n = d.data('name');
			if(an === n){
				d.cls('active');
			}else{
				d.cls('active',false);
			}
		});
		xy.OPR.push(null,'注册','registerPage');
	},true);
	
	let signInBtn = xy("#signIn");
	signInBtn.click((e)=>{
		let form = xy("#signForm");
		let formData = new FormData(form.get());
		for(let i of formData){
			console.log(i);
		}
		xy.q({
			url:'signIn',
			type:'post',
			data:formData,
//			headers:{
//				"Content-Type":"application/json;charset=UTF-8",
//				"enctype":"multipart/form-data"
//			},
			dataType:'json',
			success(d){
				console.log(d);
				location.href = d.data.url;
			}
		});
	},true);
	
// let nav = xy.d('#navigator');
//	
// nav.
	
});




