_main:
	push ebp
	push dword[@DSP + 0]
	mov ebp,esp
	mov dword[@DSP +0],ebp
	sub esp,0
	pop eax
	add dword [esp], eax
	add esp, 0
	mov ebp, esp
	pop dword[@DSP+0]
	pop ebp
	ret
section .data
	@DSP times 4 db 0
	@INTEGER: db '%d' , 0
