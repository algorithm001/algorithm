package id_123

import "testing"

func Test_isAnagram(t *testing.T) {
	type args struct {
		s string
		t string
	}
	tests := []struct {
		name string
		args args
		want bool
	}{
		{
			name: "test1",
			args: args{
				s: "anagram",
				t: "nagaram",
			},
			want: true,
		},
		{
			name: "test2",
			args: args{
				s: "anagra",
				t: "nagaram",
			},
			want: false,
		},
		{
			name: "test3",
			args: args{
				s: "中国",
				t: "国中",
			},
			want: true,
		},
		{
			name: "test4",
			args: args{
				s: "",
				t: "",
			},
			want: true,
		},
		{
			name: "test5",
			args: args{
				s: "s",
				t: "",
			},
			want: false,
		},
		{
			name: "test6",
			args: args{
				s: "",
				t: "s",
			},
			want: false,
		},
	}
	for _, tt := range tests {
		t.Run(tt.name, func(t *testing.T) {
			if got := isAnagram(tt.args.s, tt.args.t); got != tt.want {
				t.Errorf("isAnagram() = %v, want %v", got, tt.want)
			}
		})
	}
}
